//package com.springrest.springrest.services;
//
//public class CourseServiceImpl implements CourseService {
//
//}

package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service                        //To identify spring this is the service class doing all service related stuff 
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl()      //Constructor
	{
		list=new ArrayList<>();
		list.add(new Course(145,"Java core course","This Course contains basic of Java"));
		list.add(new Course(4343,"Spring Boot Course", "Creating a rest api using Spring Boot"));
	
	}

	@Override
	public List<Course> getCourses() {
		return list;                  //It will return above list 
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		for (Course course : list)
		{
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
	    list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
	    list.forEach(e -> {                                          //Traversed List using forEach method
	    	if(e.getId() == course.getId()) {
	    		e.setTitle(course.getTitle());
	    		e.setDescription(course.getDescription());
	    	}
	    });
		return course;
	}

	@Override
	public Course deleteCourse(long parseLong) {
		list=this.list.stream().filter(e ->e.getId()!=parseLong).collect(Collectors.toList());
		return null;
	}

}

