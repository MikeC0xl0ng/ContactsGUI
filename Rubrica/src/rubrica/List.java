package rubrica;

public class List {
    
    Element first_elem;
    public int length;
    
    public List(){
        length = 0;
    }
    
    public void addElement(Contatto c){
        if (!(this.contains(c.key))){
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
    }
        
    public Element getElement(String key){
        Element e = first_elem;
        while (e != null){
            if (e.c.key.equals(key)){
                return e;
            }
            e = e.next;
        }
        return null;
    }
    
    public void deleteElement(String key){
        if (this.contains(key)){
            length--;
            Element e = getElement(key);
            if (e == first_elem){
                first_elem = first_elem.next;
                e = first_elem;
                if (e != null){
                    e.prev = null;
                }
                return;
            }
            if (e == null){
                return;
            }
            if (e.prev != null){
                e.prev.next = e.next;
            }
            if (e.next != null){
                e.next.prev = e.prev;
            }
        }
        
    }
    
    public void editElement(String key, Contatto c){
        if (first_elem == null){
            first_elem = new Element(c);
            return;
        }
        Element e = this.getElement(key);
        this.deleteElement(e.c.key);
        this.addElement(c);
    }
    
    public Element getElementAt(int pos){
        Element e = first_elem;
        for (int i=0; i<pos; i++){
            if (e == null){
                return null;
            }
            e = e.next;
        }
        return e;
    }

    
    public boolean contains(String key){
        Element e = first_elem;
        while (e != null){
            if (e.c.key.equals(key)){
                return true;
            }
            e = e.next;
        }
        return false;
    }

    
}
