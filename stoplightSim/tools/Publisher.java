package tools;

import java.util.ArrayList;

public class Publisher
{
    private ArrayList<Subscriber> list = new ArrayList<Subscriber>();

    public void subscribe(Subscriber item) { this.list.add(item); }

    public void unSubscribe(Subscriber item) { this.list.remove(item); }

    public void notifySubscribers()
    {
        // loops through the list
        for (int i = 0; i < this.list.size(); i++) { this.list.get(i).update(); }
    }
}
