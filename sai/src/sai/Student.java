package sai;

public class Student {
	
		

			int sid;
			String sname;
			String sage;
			
				
				public int getsid() {
					return sid;
				}
				public void setSid(int sid) {
					this.sid = sid;
				}
				public String getSname() {
					return sname;
				}
				public void setSname(String sname) {
					this.sname = sname;
				}
				public String getSage() {
					return sage;
				}
				public void setSage(String sage) {
					this.sage = sage;
				}
				public Student(int sid, String sname, String sage) {
					super();
					this.sid = sid;
					this.sname = sname;
					this.sage = sage;
				}
				@Override
				public String toString() {
					return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
				}
			
				
				
			

	}

