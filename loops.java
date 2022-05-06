// #  Intersection: Given two (singly) linked lists, 
// # determine if the two lists intersect. 
// # Return the intersecting node. Note that 
// # the intersection is defined based on reference, 
// # not value. That is, if the kth node of the first 
// # linked list is the exact same node (by reference) 
// # as the jth node of the second linked list, then they are intersecting.


LinkedlistNode findintersection(LinkedListNode listl, LinkedListNode list2) {
    if (listl == null I I list2 == null) return null;
    
    /* Get tail and sizes. */
    Result resultl getTailAndSize(listl);
    Result result2 = getTailAndSize(list2);
    
    /* If different tail nodes, then there's no intersection. */
    if (resultl.tail != result2.tail) {
    return null;
    }
    
    /* Set pointers to the start of each linked list. */
    LinkedlistNode shorter = resultl.size < result2.size? listl : list2;
    LinkedlistNode longer = resultl.size < result2.size ? list2 : listl;
    
    /* Advance the pointer for the longer linked list by difference in lengths. */
    longer = getKthNode(longer, Math.abs(resultl.size - result2.size));
    
    /* Move both pointers until you have a collision. */
    while (shorter != longer) {
    }
    shorter = shorter.next;
    longer = longer.next;
    
    /* Return either one. */
    return longer;
    }
    class Result {
    public LinkedlistNode tail;
    public int size;
    public Result(LinkedListNode tail, int size) {
    this.tail tail;
    this.size= size;
    }
    }
    Result getTailAndSize(LinkedListNode list) {
    if (list == null) return null;
    int size = 1;
    LinkedlistNode current= list;
    while (current.next != null) {
    size++;
    current = current.next;
    }
    return new Result(current, size);
    }
    LinkedListNode getKthNode(LinkedListNode head, int k) {
    LinkedListNode current= head;
    while (k > 0 && current != null) {
    current = current.next;
    k--;
    }
    return current;
    }

// # Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
// # DEFINITION:
// # Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
// # EXAMPLE
// # Input: A -> B -> C -> D -> E -> C [the same C as earlier]
// # Output: C

LinkedListNode FindBeginning(LinkedlistNode head) {
    LinkedListNode slow head;
    LinkedlistNode fast = head;
    
    /* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
    while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) {//Collision
    break;
    }
    }
    
    /* Error check - no meeting point, and therefore no loop*/
    if (fast == null I I fast.next == null) {
    return null;
    }
    
    /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
     * Loop Start. If they move at the same pace, they must meet at Loop Start. */
    slow = head;
    while (slow!= fast) {
    slow slow.next;
    fast= fast.next;
    }
    
    /* Both now point to the start of the loop. */
    return fast;