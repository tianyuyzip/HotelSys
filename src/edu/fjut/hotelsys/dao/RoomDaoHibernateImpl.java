/**
 * 
 */
package edu.fjut.hotelsys.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.fjut.hotelsys.domain.Room;
import edu.fjut.hotelsys.service.RoomQueryHelper;
import edu.fjut.hotelsys.utils.HibernateTool;

/**
 * @author joeyang ong
 *
 */
public class RoomDaoHibernateImpl extends HibernateDaoSupport implements RoomDao {

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.dao.RoomDao#addRoom(edu.fjut.hotelsys.domain.Room)
	 */
	@Override
	public void addRoom(Room room) {

		this.getHibernateTemplate().save(room);

	}

	@Override
	public List<Room> loadAll() {
		
		return this.getHibernateTemplate().find("from Room r order by r.roomId desc");
		
	}

	@Override
	public Room getRoomById(Integer roomId) {
		
		return (Room)this.getHibernateTemplate().get(Room.class, roomId);
		
	}

	@Override
	public void updateRoom(Room room) {
		
		this.getHibernateTemplate().update(room);
		
	}

	@Override
	public void removeRoom(Integer roomId) {
		
		Room room = (Room)this.getHibernateTemplate().load(Room.class, roomId);
		this.getHibernateTemplate().delete(room);
		
	}

	@Override
	public List<Room> loadRoomsByHelper(RoomQueryHelper helper) {

		Session session = this.getSession();
		Transaction trans = session.beginTransaction();
		List<Room> roomList = null;
		
		try{
			DetachedCriteria detachedCriteria = this.genCriteiraByHelper(helper);
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			roomList = criteria.list();
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}	
		
		return roomList;
	}
	
	
	private DetachedCriteria genCriteiraByHelper(RoomQueryHelper helper){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Room.class);
		
		if(StringUtils.isNotEmpty(helper.getQryRoomNo())){
			criteria.add(Restrictions.like("roomNo", "%"+helper.getQryRoomNo()+"%"));
		}
		
		if(StringUtils.isNotEmpty(helper.getQryRoomStatus())){
			criteria.add(Restrictions.eq("roomStatus", helper.getQryRoomStatus()));			
		}
		
		if(StringUtils.isNotEmpty(helper.getQryRoomType())){
			criteria.add(Restrictions.eq("roomType", helper.getQryRoomType()));
		}
		
		if(helper.getQryHotelNo()!=null){
			criteria.createCriteria("hotel").add(Restrictions.eq("hotelNo", helper.getQryHotelNo())); //sub criteria
		}
		
		criteria.addOrder(Order.asc("roomId"));
		
		return criteria;
		
	}

	@Override
	public Long cntRoomsByHelper(RoomQueryHelper helper) {
		
		DetachedCriteria detachedCriteria = this.genCriteiraByHelper(helper);
		detachedCriteria.setProjection(Projections.rowCount());//select count(*)
		
		Session session =  this.getSession();
		Transaction trans = session.beginTransaction();
		long cnt = 0;
		
		try{
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			cnt = Long.parseLong(criteria.list().get(0).toString());
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}	
		
		return cnt;	
	}

	@Override
	public List<Room> loadScopedRoomsByHelper(RoomQueryHelper helper,int beginIdx, int fetchSize) {
		
		Session session =  this.getSession();
		Transaction trans = session.beginTransaction();
		List<Room> roomList = null;
		
		try{
			DetachedCriteria detachedCriteria = this.genCriteiraByHelper(helper);
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			roomList = criteria.setFirstResult(beginIdx).setMaxResults(fetchSize).list();
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}	

		return roomList;
	}
	

}
