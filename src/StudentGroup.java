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
			students[0] = student;
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
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
			students[index] = student;
		}		
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		else {
			students[index] = null;
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			boolean studentFound = false;
			for (int i=0; i<students.length; i++) {
				Student currStudent = students[i];
				if (currStudent!=null) {
					if (currStudent.getId() == student.getId()) {
						students[i] = null;
						studentFound = true;
						break;
					}
				}
			}
			
			if (studentFound == false) {
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
			for (int i=index+1; i<students.length; i++) {
				students[i] = null;
			}
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		else {
			boolean studentFound = false;

			for (int i=0; i<students.length; i++) {
				Student currStudent = students[i];
				
				if (studentFound == true) {
					students[i] = null;
				}
				else {
					if (currStudent!=null) {
						if (currStudent.getId() == student.getId()) { 
							studentFound = true; // student exists in the array
						}
					}
				}
				
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
			for (int i=0; i<index; i++) {
				students[i] = null;
			}
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

				if (currStudent != null) {
					if (currStudent.getId() == student.getId()) {
						studentFoundIndex = i; // student exists in the array
					}
				}

			}
			
			for (int i=0; i<studentFoundIndex; i++) {
				students[i] = null;
			}
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].compareTo(students[j + 1]) > 0)
					swap(j, j + 1);
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
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
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
	
	private void swap(int ind1, int ind2) {
		Student student = students[ind1];
		students[ind1] = students[ind2];
		students[ind2] = student;
	}
}
