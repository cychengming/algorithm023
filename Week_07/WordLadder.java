package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/*
	 * 单向BFS
	 * 
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//第一步将单词列表放入HashSet中便于判断某个单词是否在单词列表中
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0||!wordSet.contains(endWord)){
			return 0;
		}
		wordSet.remove(beginWord);
		//第二步广度优先搜索
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		//第三步 
		int step =1;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				String currentWord = queue.poll();
				if(changeWordEveryOneWord(currentWord,endWord,queue,visited,wordSet)){
					return step+1;
				}
			}
			step++;
		}
		return 0;
		
    }

	private boolean changeWordEveryOneWord(String currentWord, String endWord, Queue<String> queue, Set<String> visited,
			Set<String> wordSet) {
		char[] charArray = currentWord.toCharArray();
		for(int i=0;i<endWord.length();i++){
			//先保存后恢复
			char originChar = charArray[i];
			for(char k='a';k<='z';k++){
				if(k==originChar){
					continue;
				}
				charArray[i]=k;
				//String nextWord = charArray.toString();
				String nextWord = String.valueOf(charArray);
				if(wordSet.contains(nextWord)){
					if(nextWord.equals(endWord)){
						return true;
					}
					if(!visited.contains(nextWord)){
						queue.offer(nextWord);
						visited.add(nextWord);
					}
				}
				
			}
			//恢复原来的值
			charArray[i]=originChar;			
		}
		return false;
	}
	/*
	 * 
	 * 双向BFS
	 * 
	 */
	public int ladderLengthTwo(String beginWord, String endWord, List<String> wordList) {
		//第一步将单词列表放入HashSet中便于判断某个单词是否在单词列表中
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0||!wordSet.contains(endWord)){
			return 0;
		}
		//第二步
        Set<String> visited = new HashSet<>();
		Set<String> beginVisited = new HashSet<>();
		beginVisited.add(beginWord);
		Set<String> endVisited = new HashSet<>();
		endVisited.add(endWord);
		//第三步 
		int step =1;
		while(!beginVisited.isEmpty()&&!endVisited.isEmpty()){
			// 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
		}
		return 0;
		
    }

	private boolean changeWordEveryOneLetter(String currentWord, Set<String> endVisited, Set<String> visited,
			Set<String> wordSet, Set<String> nextLevelVisited) {
		
		char[] charArray = currentWord.toCharArray();
		for(int i=0;i<currentWord.length();i++){
			//先保存后恢复
			char originChar = charArray[i];
			for(char k='a';k<='z';k++){
				if(k==originChar){
					continue;
				}
				charArray[i]=k;
				String nextWord = String.valueOf(charArray);
				if(wordSet.contains(nextWord)){
					if(endVisited.contains(nextWord)){
						return true;
					}
					if(!visited.contains(nextWord)){
						nextLevelVisited.add(nextWord);
						visited.add(nextWord);
					}
				}
				
			}
			//恢复原来的值
			charArray[i]=originChar;			
		}
		return false;
	}

}
