
public class Test {

	public static void main(String[] args) {
		Node<Character> myChain = new Node('k', new Node('k',
				new Node('k', new Node('b',new Node('b',
						new Node('k', new Node('z', new Node('e',
								new Node('e', new Node('z'))))))))));
			
		printChain(myChain);
		compressSequences(myChain);
		printChain(myChain);
	}
	
	private static void printChain(Node<Character> chain) {
		if (chain == null)
			System.out.println(chain);
		else {
			System.out.print(chain + "-->");
			printChain(chain.getNext());
		}
	}
	
	private static void compressSequences(Node<Character> chain) {
		if (chain == null || chain.getNext()==null)
			return;
		else if (chain.getInfo()== chain.getNext().getInfo()) {
			chain.setNext(chain.getNext().getNext());
			compressSequences(chain);
		}
		else
			compressSequences(chain.getNext());
	}

}
