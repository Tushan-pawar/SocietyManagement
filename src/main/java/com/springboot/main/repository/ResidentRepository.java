<<<<<<< HEAD
package com.springboot.main.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

<<<<<<< HEAD
	Optional<Resident> findById(int residentId);

}
=======
=======
package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
