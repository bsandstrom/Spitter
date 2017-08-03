package spitter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Spittle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spitterId", nullable = false)
	private Spitter spitter;
	
	private String message;
	private Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(Spitter spitter, String message, Date time){
		this(spitter, message, time, null, null);
	}
	
	public Spittle(Spitter spitter, String message, Date time, Double longitude, Double latitude){
		this.spitter = spitter;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Spittle(){}

	public int getId() {
		return id;
	}
	
	
	public Spitter getSpitter(){
		return spitter;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this,  "id", "time");
	}
}
