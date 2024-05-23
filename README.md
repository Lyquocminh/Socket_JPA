	@ElementCollection
	@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "staff_id"))
	@Column(name = "number")
	private Set<String> phoneNumbers;


 	@Override
	public boolean addStaff(Staff staff) {
		EntityTransaction transaction = enManager.getTransaction();
		try {
			transaction.begin();
			enManager.persist(staff);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

 	@Override
	public boolean updateStaff(Staff staff) {
		EntityTransaction transaction = enManager.getTransaction();
		try {
			transaction.begin();
			enManager.merge(staff);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteStaff(long id) {
		EntityTransaction transaction = enManager.getTransaction();
		try {
			transaction.begin();
			Staff staff = enManager.find(Staff.class, id);
			enManager.remove(staff);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

 	@Override
	public Staff findStaffByID(long id) {
		Staff staff = enManager.find(Staff.class, id);
		// TODO Auto-generated method stub
		return staff;
	}

	@Override
	public Staff findStaffByName(String name) {
		Staff staff = enManager.createNamedQuery("findStaffByName", Staff.class).setParameter("name", name).getSingleResult();
		// TODO Auto-generated method stub
		return staff;
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		
		return enManager.createNamedQuery("findAllStaff", Staff.class).getResultList();
	}

	@Override
	public List<Staff> findStaffByDepartment(String departmentId) {
		// TODO Auto-generated method stub
		return enManager.createNamedQuery("findStaffByDepartment", Staff.class).setParameter("departmentId", departmentId).getResultList();
	}
```
 @NamedQueries({
	@NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByName", query = "SELECT s FROM Staff s WHERE s.name = :name"),
    @NamedQuery(name = "Staff.findByAge", query = "SELECT s FROM Staff s WHERE s.age = :age"),
    @NamedQuery(name = "Staff.findByDepartment", query = "SELECT s FROM Staff s inner join department d WHERE d.id = :departmentId"),
    @NamedQuery(name = "Staff.findByProject", query = "SELECT s FROM Staff s JOIN s.projects p WHERE p = :project")
})
```
