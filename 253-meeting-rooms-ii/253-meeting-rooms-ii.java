class Intervals{
    int start;
    int end;
    public Intervals(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Intervals[] intervalsObj = new Intervals[intervals.length];
        for(int i = 0; i< intervals.length;i++){
            intervalsObj[i] = new Intervals(intervals[i][0],intervals[i][1]);
        }
        // for(Intervals inter : intervalsObj)
           //  System.out.print(intervalsObj.length);
        
        
        Arrays.sort(intervalsObj, (a,b)->a.start-b.start);
        PriorityQueue<Intervals> pq = new PriorityQueue<>((a,b)->a.end - b.end);
        pq.add(intervalsObj[0]);
        
        for(int i = 1; i<intervalsObj.length;i++){
            Intervals earliest = pq.remove();
            if(intervalsObj[i].start >= earliest.end){
                earliest.end = intervalsObj[i].end;
            }else{
                pq.add(intervalsObj[i]);
            }
            pq.add(earliest);
        }
        
        return pq.size();
    }
}