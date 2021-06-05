class segtree{
    //static int[] arr;
    public static void main(String[] args){
        int[] arr = {5, 4, 2, 8, 1, 6, 3, 7};
        int n= 8;

        segTree(arr, n);

        // printSeg();

        System.out.println(query(0,7));

        update(arr, 3,10);

        System.out.println(query(2,3));

        update(arr, 6,9);

        System.out.println(query(2,7));
        System.out.println(query(3,3));
        System.out.println(query(1,5));
    }

    static int[] segArr;
    static int segLen;
    private static void printSeg(){
        for(int i=0;i<segArr.length;i++){
            System.out.println(segArr[i]);
        }
    }
    private static void segTree(int[] arr, int n){
        segArr = new int[4*n];
        segLen = n;
        int pre[] = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]+=arr[i]+pre[i]; 
        }

        makeSeg(1,n,pre, 1);
    }
    private static void makeSeg(int l, int r, int[] pre, int pos){
        segArr[pos] = pre[r]-pre[l-1];
        if(l!=r){
            int mid = l+(r-l)/2;
            makeSeg(l,mid, pre, pos*2);
            makeSeg(mid+1,r, pre, pos*2+1);
        }
    }

    private static int query(int l, int r){
        return getSum(l+1,r+1,1, segLen, 1);
    }
    private static int getSum(int l, int r, int start, int end, int pos){
        if(r<start || l>end)return 0;
        if(l<=start && end<=r){
            return segArr[pos];
        }
        int mid = start+(end-start)/2;
        return getSum(l,r, start,mid,pos*2)+getSum(l, r, mid+1, end, pos*2+1);
    }

    private static void update(int[] arr, int pos, int val){
        int diff = val-arr[pos];
        updateHelper(diff, 1, pos+1, 1, segLen);
    }

    private static void updateHelper(int diff, int cur, int pos, int start, int end){
        if(pos==start && pos==end){
            segArr[cur]+=diff;
            return;
        } 
        if(pos>=start && pos<=end){
            segArr[cur]+=diff;
        }
        else{
            return ;
        }
        int mid = start + (end-start)/2;
        updateHelper(diff, cur*2, pos, start, mid);
        updateHelper(diff, cur*2+1, pos, mid+1, end);
    }
}
