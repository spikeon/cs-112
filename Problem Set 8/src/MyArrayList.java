@SuppressWarnings("unchecked")
public class MyArrayList<E> {
  protected E[] data = (E[])new Object[0];

  protected void resize(int size){

    if(size < data.length) return;

    E[] tmp = (E[])new Object[size];

    for(int i = 0; i < data.length; i++){
      tmp[i] = data[i];
    }

    data = tmp;

  }

  public void add(E element){
    resize(data.length + 1);

    data[data.length - 1] = element;
  }

  public E get(int index){
    return data[index];
  }

  public int size(){
    return data.length;
  }
  public int indexOf(E element){
    for(int i = 0; i < data.length; i++){
      if(element.equals(data[i])) return i;
    }
    return -1;
  }

  public boolean contains(E element){
    return indexOf(element) != -1;
  }

  public boolean isEmpty(){
    return data.length == 0;
  }

  public void add(int index, E element){
    resize(data.length + 1);
    for(int i = data.length - 1; i > index; i--) {
      data[i] = data[i-1];
    }
    data[index] = element;
  }

  public E set(int index, E element){
    resize(index + 1);
    E r = data[index];
    data[index] = element;
    return r;
  }
  public boolean remove(E element){
    if(!contains(element)) return false;
    remove(indexOf(element));
    return true;
  }

  public E remove(int index){
    E r = null;
    E[] tmp = (E[]) new Object[data.length-1];
    int ctr = 0;
    for(int i = 0; i < data.length; i++){
      if(i != index) {
        tmp[ctr] = data[i];
        ctr++;
      }
      else r = data[i];
    }
    data = tmp;
    return r;
  }

}
