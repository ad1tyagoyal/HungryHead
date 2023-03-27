package com.pgs.FoodToEat.model;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {

   public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
@Override
	public int hashCode() {
		return Objects.hash(cid, fid, vid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		return Objects.equals(cid, other.cid) && Objects.equals(fid, other.fid) && Objects.equals(vid, other.vid);
	}
public CompositeKey(Long cid, Long vid, Long fid) {
		super();
		this.cid = cid;
		this.vid = vid;
		this.fid = fid;
	}
private Long cid ;
   private Long vid ;
   private Long fid ;
	
	
	
	
	
	
	
	
	
	
	
	
}
