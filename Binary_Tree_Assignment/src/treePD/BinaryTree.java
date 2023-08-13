package treePD;

public class BinaryTree<K extends Comparable<K>, V> {
	Entry<K, V> root;
	int height;
	
	public class Entry<Key extends Comparable<Key>, Value> {
		Key key;
		Value value;
		Entry<Key, Value> leftChild;
		Entry<Key, Value> rightChild;
		
		public Entry() {
			key = null;
			value = null;
		}
		
		public Entry(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

	    public Entry<Key, Value> getLeftChild() {
	        return leftChild;
	    }

	    public Entry<Key, Value> getRightChild() {
	        return rightChild;
	    }
	    
	    public void setLeftChild(Entry<Key, Value> e) {
	    	this.leftChild = e;
	    }
		
	    public void setRightChild(Entry<Key, Value> e) {
	    	this.rightChild = e;
	    }
	    
		public Key getKey() {
			return key;
		}
		
		public Value getValue() {
			return value;
		}
		
		public Key min() {
			if (leftChild == null)
				return key;
			else
				return leftChild.min();
		}
		
		public Key max() {
			if (rightChild == null)
				return key;
			else
				return rightChild.max();
		}
		
		public String toString() {
			if (value != null)
				return "Key: " + key + ", Value: " + value.toString();
			else
				return "Key: " + key;
		}
		
		public void insert (Key key, Value value) {
			if (this.key == key)
				return;
			
			if (key.compareTo(this.key) == 1) {
				if (leftChild == null)
					leftChild = new Entry<Key, Value>(key, value);
				else
					leftChild.insert(key, value);
			}
			
			else {
				if (rightChild == null) {
					rightChild = new Entry<Key, Value>(key, value);
				}
				
				else
					rightChild.insert(key, value);
			}
			
		}
		
		public Entry<Key, Value> search(Key key) {
			if (key.compareTo(this.key)== 0)
				return this;
			if (key.compareTo(this.key) == 1) { 
				if (leftChild != null) {
					return leftChild.search(key);
				}
			}
			
			else {
				if (rightChild != null) {
					return rightChild.search(key);
				}
			}
			
			return null;
		}
		
		public void traverseInOrder() {
	        if (leftChild != null) {
	            leftChild.traverseInOrder();
	        }
	        System.out.print(this);
	        System.out.println();
	        if (rightChild != null) {
	            rightChild.traverseInOrder();
	        }
	    }

		public void setKey(Key key) {
			this.key = key;
			
		}

		public int compareTo(Key o) {
			return key.compareTo(o);
		}
	}
	
	public BinaryTree() {
		root = new Entry<K, V>();
		height = 0;
	}
	
	public void insert(K key, V value) {
		if (root == null) {
			root = new Entry<K, V>(key, value);
		}
		
		else {
			root.insert(key, value);
		}
	}
	
	public Entry<K, V> search(K key) {
		if (root != null) {
			return root.search(key);
		}
		return null;
	}
	
	public void remove(K key) {
		//root.traverseInOrder();
		delete(root, key);
	}
	
	public Entry<K, V> delete(Entry<K, V> subtreeRoot, K key) {
		if (subtreeRoot == null)
			return subtreeRoot;

		if (key.compareTo(subtreeRoot.getKey()) == 1) {
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), key));
		}

		else if (key.compareTo(subtreeRoot.getKey()) == -1) {
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), key));
		}
		
		else {
			if (subtreeRoot.getLeftChild() == null)
				return subtreeRoot.getRightChild();
			else if (subtreeRoot.getRightChild() == null) 
				return subtreeRoot.getLeftChild();
			
			subtreeRoot.setKey(subtreeRoot.getRightChild().min());
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getKey()));
		}
		
		return subtreeRoot;
	}
	
	public int height(Entry<K, V> r) {
		if (r == null)
			return 0;
		int leftHeight = height(r.getLeftChild());
		int rightHeight = height(r.getRightChild());
		
		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}
	
	
	public Entry<K,V> getRoot() {
		return root;
	}
	
	public void setRoot(K k, V v) {
		root = new Entry<K,V>(k,v);
	}
	
	

}

