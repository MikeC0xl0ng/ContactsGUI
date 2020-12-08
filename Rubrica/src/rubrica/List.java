package rubrica;

public class List {
    
    Element first_elem;
    public int length;
    
    public List(){
        length = 0;
    }
    
    public void addElement(Contatto c){
        length++;
        Element e = new Element(c);
        if (first_elem == null){
            first_elem = e; 
            return;
        }
        first_elem.prev = e;
        e.next = first_elem;
        first_elem = e;
    }
    
    public Contatto getElement(String key){
        if (first_elem == null){
            return null;
        }
        Element e = first_elem;
        while (e != null){
            if (e.c.key == key){
                return e.c;
            }
            e = e.next;
        }
        if (e == null){
            return new Contatto();
        }
        return e.c;
    }
    
    public Contatto getElementAt(int pos){
        if (first_elem == null){
            return new Contatto();
        }
        int i = 0;
        Element e = first_elem;
        while ((e != null) && (i!=pos)){
            e = e.next;
            i++;
        }
        return e.c;
    }
    
    public void deleteElement(String key){
        length--;
        if (first_elem == null){
            return;
        }
        Element e = first_elem;
        if (first_elem.c.key == key){
            first_elem = first_elem.next;
            if (first_elem != null){
                first_elem.prev = null;
            }
            return;
        }
        while (e.next != null){
            if (e.next.c.key == key){
                e.next = e.next.next;
                if (e.next != null){
                    e.next.prev = e;
                }
                return;
            }
            e = e.next;
        }
    }
    
    public void editElement(String key, Contatto c){
        if (first_elem == null){
            return;
        }
        Element e = first_elem;
        while (e != null){
            if (e.c.key == key){
                e.c = c;
                return;
            }
            e = e.next;
        }
        if (e == null){
            return;
        }
        e.c = c;
    }
    
}
