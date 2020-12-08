package rubrica;

public class Rubrica_ {
    
    List[] contacts;
    int n;
    
    public Rubrica_(){
        n = 100;
        contacts = new List[n];
        for (int i=0; i<n; i++){
            contacts[i] = new List();
        }
    }
    
    public Rubrica_(int n_){
        n = n_;
        contacts = new List[n];
        for (int i=0; i<n; i++){
            contacts[i] = new List();
        }
    }
    
    public void addContact(Contatto c, String key){
        c.key = key;
        contacts[computeHash(key)].addElement(c);
    }
    
    public Contatto getContact(String key){
        return contacts[computeHash(key)].getElement(key);
    }
    
    public void deleteContact(String key){
        contacts[computeHash(key)].deleteElement(key);
    }
    
    public void editContact(String key, Contatto c){
        contacts[computeHash(key)].editElement(key, c);
    }
    
    public int computeHash(String key){
        int hash = 0;
        int n_ = key.length();
        for (int i=0; i<n_; i++){
            hash += (int) key.charAt(i);
            hash = hash % n;
        }
        return hash;
    }
    
}
