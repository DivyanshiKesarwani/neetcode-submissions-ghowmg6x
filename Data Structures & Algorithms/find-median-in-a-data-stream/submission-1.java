class MedianFinder {
    PriorityQueue<Integer>min;
    PriorityQueue<Integer>max;
    public MedianFinder() {
        this.min=new PriorityQueue<>();
        this.max=new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(max.isEmpty()||num<=max.peek())
        {
            max.add(num);
        }
        else{
            min.add(num);
        }
        if(max.size()>min.size()+1)
        {
            min.add(max.poll());
        }
        else if(min.size()>max.size())
        {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
        return max.peek();
    }

    return (max.peek() + min.peek()) / 2.0;
        }
}
