class Node {
    Node prev;
    Node next;
    String tokenId;
    int expiry;

    Node(String tokenId,int expiry) {
        this.tokenId = tokenId;
        this.expiry = expiry;
    }
}

class AuthenticationManager {

    Node head;
    Node tail;
    int timeToLive;
    HashMap<String,Node> hmap;

    public AuthenticationManager(int timeToLive) {
        head = new Node("",-1);
        tail = new Node("",-1);
        head.next = tail;
        tail.prev = head;
        this.timeToLive = timeToLive;
        hmap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(tokenId,currentTime + timeToLive);

        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
        hmap.put(tokenId,node);
    }

    public void renew(String tokenId, int currentTime) {
        if(hmap.containsKey(tokenId) && hmap.get(tokenId).expiry>currentTime) {
            Node node = hmap.get(tokenId);
            node.expiry = currentTime+timeToLive;
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            node.next = tail;
            tail.prev = node;   
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while(head.next.expiry>0 && head.next.expiry<=currentTime) {
            Node node = head.next;
            hmap.remove(node.tokenId);
            head.next = node.next;
            node.next.prev = head;
        }
        return hmap.size();
    }
}