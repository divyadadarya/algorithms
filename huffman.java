import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode>{
	int freq;
	char data;
	HuffmanNode left, right;

	@Override
	public int compareTo(HuffmanNode o){
		return freq - o.freq;
	}
}

class Main{

	static HuffmanNode root;

	static Map<Character, String> charBinaryMapping = new HashMap<>();

	private static HuffmanNode generateTree(Map<Character, Integer> f){
		PriorityQueue<HuffmanNode> priorityQ = new PriorityQueue<HuffmanNode>();

		Set<Character> keySet = f.keySet();

		for(Character character : keySet){
			HuffmanNode node = new HuffmanNode();

			node.data = character;
			node.freq = f.get(character);
			node.left = null;
			node.right = null;

			priorityQ.offer(node);
		}

		while(priorityQ.size() > 1){

			HuffmanNode first = priorityQ.peek();
			priorityQ.poll();

			HuffmanNode second = priorityQ.peek();
			priorityQ.poll();

			HuffmanNode mergeNode = new HuffmanNode();

			mergeNode.left = first;
			mergeNode.right = second;
			mergeNode.freq = first.freq + second.freq;
			mergeNode.data = '-';
			root = mergeNode;

			priorityQ.offer(mergeNode);
		}

		return priorityQ.poll();
	}

	private static void setBinaryCode(HuffmanNode node, StringBuilder str){

		if(node != null){

			if(node.left == null && node.right == null){
				charBinaryMapping.put(node.data, str.toString());
			}

			else{
				str.append('0');
				setBinaryCode(node.left, str);
				str.deleteCharAt(str.length() - 1);

				str.append('1');
				setBinaryCode(node.right, str);
				str.deleteCharAt(str.length() - 1);
			}
		}
		
	}

	private static String encode(String str){
		Map<Character, Integer> f = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			if(!f.containsKey(str.charAt(i))){
				f.put(str.charAt(i), 0);
			}

			f.put(str.charAt(i), f.get(str.charAt(i)) + 1);
		}

		HuffmanNode root = generateTree(f);

		setBinaryCode(root, new StringBuilder());

		System.out.println("Binary Codes : " + charBinaryMapping);

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			s.append(charBinaryMapping.get(c));
		}

		return s.toString();
	}

	public static void main(String[] args){
		String str = "ABBCCCCGGGGDEAAAEDBBBDFAGG";

		String code = encode(str);

		System.out.println("Final Coded String = " + code);
	}
}

//time complexity - O(nlogk) where k = number of nodes in the generated tree and n = leaf nodes
//space complexity - O(k)