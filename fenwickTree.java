class fenwickTree {
    public static void main(String[] args){
        int n = 16;
        int[] arr ={1,2,3,4,5,6,7,8,9};
        print(arr);    

        constructFTree(arr);
        print(ftree);
        System.out.println("1 to 3 -> "+get(1, 3));
        System.out.println("1 to 9 -> "+get(1, 9));
        System.out.println("5 to 9 -> "+get(5, 9));
        System.out.println("Updating...");
        update(3,-3);
        update(7,-7);
        print(ftree);
        System.out.println("1 to 3 -> "+get(1, 3));
        System.out.println("1 to 9 -> "+get(1, 9));
        System.out.println("5 to 9 -> "+get(5, 9));
    }
    static long[] ftree;
    static int len;

    static void constructFTree(int[] arr){
        len = arr.length;
        ftree = new long[len+1];
        for(int i=1;i<=len;i++){
            update(i,arr[i-1]);
        }
    }

    static void update(int pos, int val){
        if(pos>len)return;
        ftree[pos] += val;
        update(pos+lsb(pos), val);
    }

    static long get(int start, int end){
        long plus = 0;
        while(end>0){
            plus+=ftree[end];
            end-= lsb(end);
        }
        long min =0;
        start--;
        while(start>0){
            min+=ftree[start];
            start-= lsb(start);
        }
        return plus-min;
    }

    static void print(long[] arr){
        for(long e: arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static void print(int[] arr){
        for(long e: arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static int lsb(int n){
        return n&(-n);
//        int res = 1;
//        while(true){
//            if((n&1)==1){
//                return res;
//            }
//            res = res<<1;
//            n = n>>1;
//        }
    }

}
