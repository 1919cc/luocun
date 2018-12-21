package com.classic.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 */

public class Leetcode295FindMediumFromDataStream {

    PriorityQueue<Integer> large = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>();
    
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        
//    }
    
    public void addNum(int num) {
        large.offer(num); // O(LogN)
        small.offer(-large.poll());
        if (large.size() < small.size()) large.offer(-small.poll());
    }
    
    public double findMedian() {
        return large.size() > small.size()
            ? large.peek() : (double)(large.peek() - small.peek()) / 2;
    }
}