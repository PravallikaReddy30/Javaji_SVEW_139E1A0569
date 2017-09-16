import java.util.ArrayList;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		//return null;
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if (students == null) {
			throw new IllegalArgumentException();
		} else {
			this.students = students; 
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		//return null;
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			return students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			students[index] = student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			//students[0] = student;
			Student[] studentsArr = new Student[students.length+1];
			studentsArr[0] = student;
			for (int i=0; i< students.length; i++) {
				studentsArr[i+1] = students[i];
			}
			this.students = studentsArr;
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			Student[] studentsArr = new Student[students.length+1];
			for (int i=0; i< students.length; i++) {
				studentsArr[i] = students[i];
			}
			this.students = studentsArr;

			int lastIndex = students.length-1;
			students[lastIndex] = student;	
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			Student[] studentsArr = new Student[students.length+1];
			for (int i=0; i< index; i++) {
				studentsArr[i] = students[i];
			}
			studentsArr[index] = student;
			
			for (int i=index; i< students.length; i++) {
				studentsArr[i+1] = students[i];
			}
			this.students = studentsArr;
		}		
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			
			Student[] studentsArr = new Student[students.length-1];
			for (int i=0; i< index; i++) {
				studentsArr[i] = students[i];
			}
			for (int i=index+1; i< students.length; i++) {
				studentsArr[i-1] = students[i];
			}
			this.students = studentsArr;
			
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			int studentFoundIndex = -1;
			for (int i = 0; i < students.length; i++) {
				Student currStudent = students[i];
				if (currStudent.getId() == student.getId()) {
					students[i] = null;
					studentFoundIndex = i;
					break;
				}
			}
			
			if (studentFoundIndex != -1) {
				Student[] studentsArr = new Student[students.length - 1];
				for (int i = 0; i < studentFoundIndex; i++) {
					studentsArr[i] = students[i];
				}
				for (int i = studentFoundIndex + 1; i < students.length; i++) {
					studentsArr[i - 1] = students[i];
				}
				this.students = studentsArr;
			}

			else {
				throw new IllegalArgumentException("Student not exist");
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			Student[] studentsArr = new Student[index];
			for (int i = 0; i < index; i++) {
				studentsArr[i] = students[i];
			}
			this.students = studentsArr;
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			int studentFoundIndex = -1;

			for (int i = 0; i < students.length; i++) {
				Student currStudent = students[i];
				if (currStudent.getId() == student.getId()) {
					studentFoundIndex = i; // student exists in the array
					break;
				}
			}
			
			if (studentFoundIndex != -1) {
				Student[] studentsArr = new Student[studentFoundIndex];
				for (int i = 0; i < studentFoundIndex; i++) {
					studentsArr[i] = students[i];
				}
				this.students = studentsArr;
			}
			
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			int newlength = students.length-index;
			Student[] studentsArr = new Student[newlength];
			for (int i = 0; i < studentsArr.length; i++) {
				studentsArr[i] = students[i+index];
			}
			this.students = studentsArr;
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			int studentFoundIndex = -1;

			for (int i = 0; i < students.length; i++) {
				Student currStudent = students[i];
				if (currStudent.getId() == student.getId()) {
					studentFoundIndex = i; // student exists in the array
				}
			}
			
			int newlength = students.length-studentFoundIndex;
			Student[] studentsArr = new Student[newlength];
			for (int i = 0; i < studentsArr.length; i++) {
				studentsArr[i] = students[i+studentFoundIndex];
			}
			this.students = studentsArr;
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].compareTo(students[j + 1]) > 0) {
					swap(j, j + 1);
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i=0; i<students.length; i++) {
			Student currStudent = students[i];
			if (currStudent.getBirthDate().compareTo(date) <= 0) {
				list.add(currStudent);
			}
		}
		Student[] studentsArr = list.toArray(new Student[0]);
		return studentsArr;		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max = -1;
		for (int i=0; i<students.length; i++) {
			Student currStudent = students[i];
			if (currStudent.getAvgMark()>max) {
				max = currStudent.getAvgMark();
			}
		}
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i=0; i<students.length; i++) {
			Student currStudent = students[i];
			if (currStudent.getAvgMark() == max) {
				list.add(currStudent);
			}
		}
		Student[] studentsArr = list.toArray(new Student[0]);
		return studentsArr;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			boolean studentFound = false;

			for (int i = 0; i < students.length; i++) {
				Student currStudent = students[i];

				if (studentFound == true) {
					return currStudent;
				} else {
					if (currStudent.getId() == student.getId()) {
						studentFound = true; // student exists in the array
					}

				}

			}
		}
		return null;
	}
	
	private void swap(int ind1, int ind2) {
		Student student = students[ind1];
		students[ind1] = students[ind2];
		students[ind2] = student;
	}
}
