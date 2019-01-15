package rest.food.ordering.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ServingLocation")
@Entity
@Table(name="SERVING_LOCATION")
public class ServingLocationDBO {	

	@Id
	@GeneratedValue(generator = "SER_LOC_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SER_LOC_SEQ", sequenceName = "SERVING_LOCATION_SEQUENCE",initialValue=1, allocationSize=1)
	@Column(name="LOCATION_ID",nullable = false)
	private long locationId;

	@Column(name="LOCATION_NAME",nullable = false, length = 100)
	private String locationName;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
