package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/*
	 * ����BFS
	 * 
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//��һ���������б����HashSet�б����ж�ĳ�������Ƿ��ڵ����б���
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0||!wordSet.contains(endWord)){
			return 0;
		}
		wordSet.remove(beginWord);
		//�ڶ��������������
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		//������ 
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
			//�ȱ����ָ�
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
			//�ָ�ԭ����ֵ
			charArray[i]=originChar;			
		}
		return false;
	}
	/*
	 * 
	 * ˫��BFS
	 * 
	 */
	public int ladderLengthTwo(String beginWord, String endWord, List<String> wordList) {
		//��һ���������б����HashSet�б����ж�ĳ�������Ƿ��ڵ����б���
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0||!wordSet.contains(endWord)){
			return 0;
		}
		//�ڶ���
        Set<String> visited = new HashSet<>();
		Set<String> beginVisited = new HashSet<>();
		beginVisited.add(beginWord);
		Set<String> endVisited = new HashSet<>();
		endVisited.add(endWord);
		//������ 
		int step =1;
		while(!beginVisited.isEmpty()&&!endVisited.isEmpty()){
			// ����ѡ��С�Ĺ�ϣ�������ɢ�����ǵ����������
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            // �߼��������֤ beginVisited ����Խ�С�ļ��ϣ�nextLevelVisited ����ɢ����Ժ󣬻��Ϊ�µ� beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            // ԭ���� beginVisited �������� nextLevelVisited ��ʼ�µ�˫�� BFS
            beginVisited = nextLevelVisited;
            step++;
		}
		return 0;
		
    }

	private boolean changeWordEveryOneLetter(String currentWord, Set<String> endVisited, Set<String> visited,
			Set<String> wordSet, Set<String> nextLevelVisited) {
		
		char[] charArray = currentWord.toCharArray();
		for(int i=0;i<currentWord.length();i++){
			//�ȱ����ָ�
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
			//�ָ�ԭ����ֵ
			charArray[i]=originChar;			
		}
		return false;
	}

}
