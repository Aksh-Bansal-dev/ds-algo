class QuickSort{
    public static void main(String[] args){
        int[] arr = new int[]{10,6,3,4,10,16,14,12,2,12};

        System.out.println("Original Array");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();

        sort(arr,0,arr.length-1);

        System.out.println("Final Array");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void sort(int[] arr,int start, int end){
        if(start>=end)return;

        int pos = start;
        for(int i=start+1;i<=end;i++){
            if(arr[start]>arr[i]){
                int temp = arr[pos+1];
                arr[pos+1] = arr[i];
                arr[i] = temp;
                pos++;
            }
        }
        
        int temp = arr[pos];
        arr[pos] = arr[start];
        arr[start] = temp;

        sort(arr,pos+1,end);
        sort(arr,start,pos-1);

    }
}
