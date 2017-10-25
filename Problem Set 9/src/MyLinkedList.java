public class MyLinkedList<E> {

  private Node<E> head;

  public MyLinkedList(){
    head = null;
  }

  public void addFirst(E item){
    head = new Node<E>(item, head);
  }

  public void addLast(E item){
    if(head == null) addFirst(item);
    else{
      Node<E> tmp = head;
      while(tmp.next != null) tmp = tmp.next;
      tmp.next = new Node<E>(item, null);
    }
  }

  public void insertAfter(E key, E newNode){
    Node<E> tmp = head;
    while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;
    if(tmp != null) tmp.next = new Node<E>(newNode, tmp.next);
  }


  private static class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next){
      this.data = data;
      this.next = next;
    }
  }

  public void add(E element){
    addLast(element);
  }

  public E get(int index){
    Node<E> tmp = head;
    for(int i = 1; i <= index; i++){
      tmp = tmp.next;
    }
    return tmp.data;
  }

  public int size(){
    Node<E> tmp = head;
    int ctr = 0;
    while(tmp.next != null) {
      tmp = tmp.next;
      ctr++;
    }
    return ++ctr;
  }

  public int indexOf(E element){
    Node<E> tmp = head;
    int index = 0;
    while(tmp != null){
      if(tmp.data.equals(element)) return index;
      tmp = tmp.next;
      index ++;
    }
    return -1;
  }
  public boolean contains(E element){
    return indexOf(element) != -1;
  }
  public boolean isEmpty(){
    return head == null;
  }
  public void add(int index, E element){
    // Not Working 
    Node<E> tmp = head;

    while(index >= size()){
      addLast(null);
    }
    if(index == 0) addFirst(element);
    else {
      for (int i = 1; i <= index; i++) {
        tmp = tmp.next;
      }
      tmp.next = new Node<E>(element, tmp.next);
    }

  }
  public E set(int index, E element){
    Node<E> tmp = head;
    for(int i = 0; i < index; i++){
      tmp = tmp.next;
    }
    E r = tmp.data;
    tmp.data = element;
    return r;

  }

}
