package bloodbank.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Hibernate;

/**
 * The persistent class for the blood_bank database table.
 */
//TODO BB01 - add the missing annotations.
//TODO BB02 - BloodBank has subclasses PrivateBloodBank and PublicBoodBank. Look at week 9 slides for InheritanceType.
//TODO BB03 - do we need a mapped super class? which one?
public abstract class BloodBank implements Serializable {
	private static final long serialVersionUID = 1L;

	// TODO BB04 - add the missing annotations.
	private String name;

	// TODO BB05 - add the 1:M annotation. This list should be effected by changes to this object (cascade).
	// TODO BB06 - add the join column details.
	private Set< BloodDonation> donations;

	protected BloodBank() {
	}

	public Set< BloodDonation> getDonations() {
		return donations;
	}

	public void setDonations( Set< BloodDonation> donations) {
		this.donations = donations;
	}

	public void setName( String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + Objects.hash( getName());
	}

	@Override
	public boolean equals( Object obj) {
		if ( obj == null)
			return false;
		if ( this == obj)
			return true;
		if ( !( getClass() == obj.getClass() || Hibernate.getClass( obj) == getClass()))
			return false;
		BloodBank other = (BloodBank) obj;
		return Objects.equals( getName(), other.getName());
	}

}