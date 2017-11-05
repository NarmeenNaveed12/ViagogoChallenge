public class Pairs<X, Y>  {
   X x;
   Y y;


   public Pairs(X x, Y y) {
      this.x = x;
      this.y = y;
   }

public void setX(X x){
   this.x = x; 
}

public void setY(Y y){ 
  this.y = y; 
}

public X getX() {
  return this.x;
}

public Y getY() {
  return this.y;
}

public static <X, Y> Pairs<X, Y> make(X x, Y y) { 
  return new Pairs<X, Y>(x, y);
}

public int hashCode() {
  return (x !=null ? x.hashCode() : 0) + 31 * (y != null ? y.hashCode() : 0);
}


public boolean equals(Object o) {
if (o == null || o.getClass() != this.getClass()) { 
  return false; 
}
  Pairs that = (Pairs) o;
  return (x == null ? that.x == null : x.equals(that.x))
  && (y == null ? that.y == null : y.equals(that.y));
}

public String toString(){
  return x + "," + y;
}

}