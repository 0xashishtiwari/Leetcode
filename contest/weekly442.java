 
  /*
question 1 
> As in question already given given we can have n * n  cargo deck on a ship  and it can handle only w weight
> we will iterate for the containers n*n add these container weight to a variable  
> on the addition we will keep checking that weight does't exceed the max weight capacity
> after breaking the loop we can simply return the container count by total weight / each container wight (wg/w)

*/


class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
            int t = n *n;
            int wg =0;
               for(int i=0;i<n*n;i++){
                   if(wg+w<=maxWeight){
                       wg+=w;
                   }else{
                       break;
                   }
               }
        return wg/w;
    }
}

  /*
question 2
> first we gonna create a intersect func to calculate the common distinct nums by passing the both the arrays we can do it by using set
> as in qestion it given that node are those index which are in of properties array [0 , n-1] .
> and two node can be visited if the intersect function can satisfy the condn of >=k.
> we need to find the connected components of graph we are not gonna create the graph but we are gonna do dfs in this 
> we keep track of visited node in the visited array to keep the track of visited node in a sigle component
> simple pass properties, visited array , k , and starting node of the dfs
> on the dfs function mark the node visited in the array 
  visited[i] = true;

> then each we have to check all the node that there might me possibility that 0th node is connected to n-1th node
> we will do it using a loop to the props array call the dfs function for ith node if :- 
  > it is not visited and it satisfying the two node intersect contidion then call the dfs function for jth node and visit it

  the counter will counts all the component that has been started visiting from previous for loop
  we can simply return the number of components
  
*/

class Solution {
    public int intersect(int arr1[] , int arr2[]){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        Set<Integer>common = new HashSet<>();
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                common.add(arr2[i]);
            }
        }
        return common.size();
    }
    public void dfs(int[][]properties , boolean vis[] , int k , int i){
        vis[i] =true;
        for(int j=0;j<properties.length;j++){
            if(!vis[j]&&intersect(properties[i] , properties[j])>=k){
                dfs(properties , vis , k , j);
            }
        }
    }
    
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
            boolean vis[] = new boolean[n];
              int cnt =0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(properties , vis  , k , i);
            }
        }
        return cnt;
    }
}



