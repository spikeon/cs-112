public class MikeList<E> extends MyAbstractArrayList<E> {

  private int length;

  public MikeList() {
    length = 0;
  }

  public MikeList(int size){
    length = 0;
    while(data_store.length < size){
      makeArrayBigger();
    }
  }

  public MikeList(E[] start){
    length = 0;
    for(E i : start){
      add(i);
    }
  }

  @Override
  public void add(E element) {
    length++;
    if(length > data_store.length) makeArrayBigger();
    data_store[length-1] = element;
  }

  @Override
  public int size() {
    return length;
  }

  @Override
  public E get(int subscript) {
    return data_store[subscript];
  }

  @Override
  public E remove(int subscript) {

    E o = data_store[subscript];

    data_store[subscript] = null;

    E[] temp_data_store = (E[]) new Object[data_store.length];

    int i = 0;

    for(E d : data_store){
      if(d != null) temp_data_store[i++] = d;
    }

    length = i;

    data_store = (E[]) temp_data_store;

    return o;
  }
}
