
public class IntegerArray {
    private int[] arr;

    IntegerArray(int size) {
        arr = new int[size];
    }

    public void setElement(int index, int element) {
        if (index >= 0 && index < arr.length)
            arr[index] = element;
        else throw new RuntimeException("Array Index is Out of Boumnd");

    }

    public int getElement(int index) {
        if (index >= 0 && index < arr.length)
            return arr[index];
        else throw new RuntimeException("Array Index is Out of Boumnd");

    }

    class IntegerArrayIterator {
        private int index = 0;

        private IntegerArrayIterator() {
        }

        public boolean hasNext() {
            return index < arr.length;
        }

        public int next() {
            if (index == arr.length)
                throw new RuntimeException("Array Index is Out of Boumnd");

            return arr[index++];
        }
    }

    public IntegerArrayIterator getIterator() {
        return new IntegerArrayIterator();

    }


    public static void main(String[] args) {
        IntegerArray obj = new IntegerArray(6);

        //obj.setElement(0,1);

       for(int i=0;i<6;i++){
           obj.setElement(i,(i+1)*2);
       }
        System.out.println( obj.getElement(0));
       
       IntegerArray.IntegerArrayIterator itr=obj.getIterator();
               while(itr.hasNext())
                   System.out.println(itr.next());
    }
}
