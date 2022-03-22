class Heap {
  Node[] heap;
  int position;
  Heap() {
    heap = new Node[2];
    position = 0;
  }
  public Node insert(Node obj) {
    return insert(obj, this.position);
  }
  private Node insert(Node obj, int position) {
    if (position == heap.length) {
      // arraydouble(); to be implemented
    }
    int comp = obj.compareTo(heap[(position-position%2)/2]);
    if (comp < 0) { // stick at end
      heap[position] = obj;
      position++;
    } else if (comp > 0) { // stick it up one level 
      Node temp = heap[position];
      heap[position] = obj;
      while (true) {
        position = (position-position%2)/2;
        comp = obj.compareTo(heap[(position-position%2)/2]);
        Node temp = heap[position];
        if (position == 0 || comp < 0) {
          heap[position] = obj;
          heap[(position%2)/2] = temp;
        }
      }
      this.position++;
    } else { // equal
      heap[(position-position%2)/2] = obj;
    }
    return (Node) obj;
  }
  class Node implements Comparable<Node> {
    Object data;
    @Override
    public int compareTo(Node obj) {
      return this.hashCode() - obj.hashCode();
    }
  }
}

