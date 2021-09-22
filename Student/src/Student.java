
public final class Student {
   private final String name;
   private final int age;
   private final String group;
   
   public Student(String name, int age, String group) {
	   this.name = name;
	   this.age = age;
	   this.group = group;
   }
   
   public int hashCode() {
	   int prime = 19;
	   int hash = 0;
	   hash += age;
	   hash += !name.equals(null)  ? name.hashCode()  * prime : 0;
	   hash += !group.equals(null) ? group.hashCode() * prime * prime : 0;
	   return hash;
   }
   
   public boolean equals(Student st2) {
	   boolean equalName = this.name.equals(st2.name);
	   boolean equalAge  = this.age == st2.age;
	   boolean equalGroup = this.group.equals(st2.group);
	   
	   if (st2.hashCode() == this.hashCode()){ 
		   return false;
	   } else if(equalName && equalAge && equalGroup){
		   return true;
	   } else {
		   return false;
	   }	   	   
   }   
}