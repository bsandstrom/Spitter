package spitter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id = 0;
	
	String testDataCol;
	
	public TestData(){}

	public TestData(String testDataCol) {
		this.testDataCol = testDataCol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestDataCol() {
		return testDataCol;
	}

	public void setTestDataCol(String testDataCol) {
		this.testDataCol = testDataCol;
	}

	@Override
	public String toString() {
		return "TestData [id=" + id + ", testDataCol=" + testDataCol + "]";
	}
	
}
