package com.infomerica.infomericaejectforce.DAO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Employee Object
 */
@Entity
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private int Empid;
	@Column(name = "EMPLOYEE_NAME")
	private String Empname;
	@Column(name = "PHONENUMBER")
	private long Phnno;
	@Column(name = "DATE_OF_JOINING")
	private LocalDate dateofjoining;
	@Column(name = "DATE_OF_RELIEVING")
	private LocalDate dateofrelieving;
	@Column(name = "TECHNOLOGY")
	private String technology;
	@Column(name = "EXPERIENCE")
	private int experience;
	@Column(name = "CERTIFICATIONS")
	private String certifications;
	@Column(name = "CURRENT_COMPANY")
	private String currentcompany;
	@Column(name = "PREVIOUS_COMPANY")
	private String previouscompany;
	@Column(name = "CTC")
	private int ctc;
	@Column(name = "QUALIFICATION")
	private String Qualification;

	public Employee() {
	}

	public Employee(int empid, String empname, long phnno, LocalDate dateofjoining, LocalDate dateofrelieving,
			String technology, int experience, String certifications, String currentcompany, String previouscompany,
			int ctc, String qualification) {
		super();
		Empid = empid;
		Empname = empname;
		Phnno = phnno;
		this.dateofjoining = dateofjoining;
		this.dateofrelieving = dateofrelieving;
		this.technology = technology;
		this.experience = experience;
		this.certifications = certifications;
		this.currentcompany = currentcompany;
		this.previouscompany = previouscompany;
		this.ctc = ctc;
		Qualification = qualification;
	}

	public int getEmpid() {
		return Empid;
	}

	public void setEmpid(int empid) {
		Empid = empid;
	}

	public String getEmpname() {
		return Empname;
	}

	public void setEmpname(String empname) {
		Empname = empname;
	}

	public long getPhnno() {
		return Phnno;
	}

	public void setPhnno(long phnno) {
		Phnno = phnno;
	}

	public LocalDate getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public LocalDate getDateofrelieving() {
		return dateofrelieving;
	}

	public void setDateofrelieving(LocalDate dateofrelieving) {
		this.dateofrelieving = dateofrelieving;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getCurrentcompany() {
		return currentcompany;
	}

	public void setCurrentcompany(String currentcompany) {
		this.currentcompany = currentcompany;
	}

	public String getPreviouscompany() {
		return previouscompany;
	}

	public void setPreviouscompany(String previouscompany) {
		this.previouscompany = previouscompany;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	@Override
	public String toString() {
		return "EmployeeDAO [Empid=" + Empid + ", Empname=" + Empname + ", Phnno=" + Phnno + ", dateofjoining="
				+ dateofjoining + ", dateofrelieving=" + dateofrelieving + ", technology=" + technology
				+ ", experience=" + experience + ", certifications=" + certifications + ", currentcompany="
				+ currentcompany + ", previouscompany=" + previouscompany + ", ctc=" + ctc + ", Qualification="
				+ Qualification + "]";
	}

}
