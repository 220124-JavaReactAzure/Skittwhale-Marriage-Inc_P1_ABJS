package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Services {

	@Id
	@Column(name = "serviceid", unique = true, nullable = false)
	private String serviceId;

	@Column(name = "servicename", unique = true)
	private String serviceName;

	@Column(name = "servicecost")
	private double serviceCost;

	@Column(name = "servicetypeid")
	private int serviceTypeId;

	public Services(String serviceId, String serviceName, double serviceCost, int serviceTypeId) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
		this.serviceTypeId = serviceTypeId;
	}

	public Services(String serviceId) {
		super();
		this.serviceId = serviceId;
	}

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceCost, serviceId, serviceName, serviceTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		return Double.doubleToLongBits(serviceCost) == Double.doubleToLongBits(other.serviceCost)
				&& Objects.equals(serviceId, other.serviceId) && Objects.equals(serviceName, other.serviceName)
				&& serviceTypeId == other.serviceTypeId;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceCost=" + serviceCost
				+ ", serviceTypeId=" + serviceTypeId + "]";
	}

}
