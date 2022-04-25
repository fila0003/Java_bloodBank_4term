package bloodbank.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

/**
 * The persistent class for the donation_record database table.
 */
//TODO DR01 - add the missing annotations.
//TODO DR02 - do we need a mapped super class? which one?
public class DonationRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	// TODO DR03 - add annotations for 1:1 mapping. changes here should cascade.
	private BloodDonation donation;

	// TODO DR04 - add annotations for 1:1 mapping. changes here should not cascade.
	private Person owner;

	private byte tested;

	public DonationRecord() {

	}

	public BloodDonation getDonation() {
		return donation;
	}

	public void setDonation( BloodDonation donation) {
		this.donation = donation;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner( Person owner) {
		this.owner = owner;
	}

	public byte getTested() {
		return tested;
	}

	public void setTested( boolean tested) {
		this.tested = (byte) ( tested ? 0b0001 : 0b0000);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + Objects.hash( getId(), getOwner().getId(), getTested());
	}

	@Override
	public boolean equals( Object obj) {
		if ( obj == null)
			return false;
		if ( this == obj)
			return true;
		if ( !( getClass() == obj.getClass() || Hibernate.getClass( obj) == getClass()))
			return false;
		DonationRecord other = (DonationRecord) obj;
		return Objects.equals( getId(), other.getId()) && Objects.equals( getOwner().getId(), other.getOwner().getId())
				&& getTested() == other.getTested();
	}

}