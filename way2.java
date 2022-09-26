public class way2 {

    static int[] solve(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;
        for (int index = start + com1; index <= end; index++) {
    
          if (index % com2 == 0) {
            ways[index] = ways[index - com1] + ways[index / com2];
          } else {
            ways[index] = ways[index - com1];
          }
        }
        return ways;
      }
    
      static String print(int[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
          sb.append(String.format("(%d)%d ", i, items[i]));
        }
        return sb.toString();
      }
    
      
    public static void find_way1(int[] ways, int start, int end, int com1, int com2) {
        StringBuilder way = new StringBuilder();
          if ((ways[end / com2] != 0) && (end / com2 >= start) && (end%com2 == 0)) {
            way.append("k2");
            find_way1(ways, start, end/com2, com1, com2); 
          }
          else if ((ways[end - com1] != 0) && (end - com1 >= start)) {
              way.append("k1");
              find_way1(ways, start, end-com1, com1, com2);
            } else return;
        System.out.print(way +" ");
      }
    public static void find_way2(int[] ways, int start, int end, int com1, int com2) {
        StringBuilder way = new StringBuilder();
        if ((start * com2 <= end) && (ways[start * com2] != 0)) {
            way.append("k2");
            find_way2(ways, start * com2, end, com1, com2); 
        }
        else if ((start + com1 <= end) && (ways[start + com1] != 0)) {
            way.append("k1");
            find_way2(ways, start + com1, end , com1, com2);
          } else return;
        System.out.print(way +" ");
    }
    
      public static void main(String[] args) {
        int start = 2; 
        int end = 11; 
        int com1 = 1; 
        int com2 = 2; 
    
        int[] arr = solve(start, end, com1, com2); 
        System.out.printf("машрутов %d\n", arr[arr.length - 1]);
    
        //System.out.println(print(arr)); 
        find_way1(arr, start, end, com1, com2);
        System.out.println(" ");
        find_way2(arr, start, end, com1, com2);
      }
}