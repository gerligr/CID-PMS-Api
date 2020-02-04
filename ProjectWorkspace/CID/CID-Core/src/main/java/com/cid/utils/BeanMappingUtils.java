package com.cid.utils;

import org.apache.commons.lang3.StringUtils;

import com.cid.beans.UserDto;
import com.cid.model.User;

public class BeanMappingUtils {

	
	public static User dto2Model(UserDto dto) {
		User user = new User();
		if (dto.getId() != null) {
			user.setId(dto.getId());
		}
		user.setDepartmentId(dto.getDepartmentId());
		user.setTeamId(dto.getTeamId());
		user.setRoleId(dto.getRoleId());
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		return user;
	}

	public static UserDto model2Dto(User user) {
		UserDto dto = new UserDto();
		dto.setDepartmentId(user.getDepartmentId());
		dto.setTeamId(user.getTeamId());
		dto.setRoleId(user.getRoleId());
		dto.setFirstname(user.getFirstname());
		dto.setLastname(user.getLastname());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		return dto;
	}

	

	/*public static EmployeeDto model2Dto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmail(employee.getEmail());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setId(employee.getId());
		dto.setTeamLead(employee.isTeamLead());
		String[] shortArray = new String[employee.getRoles().size()];
		for (int i = 0; i < shortArray.length; i++) {
			shortArray[i] = employee.getRoles().get(i).getName();
		}
		dto.setRoles(shortArray);
		dto.setUsername(employee.getUsername());
		return dto;
	}

	public static Topic dto2Model(TopicDto dto) {		
		Topic topic = new Topic();
		topic.setName(dto.getName());
		return topic;
	}

	public static TopicDto model2Dto(Topic model) {
		TopicDto dto = new TopicDto();
		dto.setId(model.getId());
		dto.setName(model.getName());
		return dto;
	}
	
	
	public static Lecture dto2Model(LectureDto dto) {		
		Lecture lecture = new Lecture();
		lecture.setTitle(dto.getTitle());
		lecture.setContent(dto.getContent());
		lecture.setId(dto.getId());
		return lecture;
	}
	
	public static LectureDto model2Dto(Lecture model) {		
		LectureDto dto = new LectureDto();
		dto.setTitle(model.getTitle());
		dto.setContent(model.getContent());
		dto.setId(model.getId());
		return dto;
	}
	
	public static Trainer dto2Model(TrainerDto dto) {		
		Trainer trainer = new Trainer();
		if (dto.getId() != null) {
			trainer.setId(dto.getId());
		}
		trainer.setFirstName(dto.getFirstName());
		trainer.setLastName(dto.getLastName());
		trainer.setIdCode(dto.getIdCode());
		trainer.setEmail(dto.getEmail());
		trainer.setAddressRoad(dto.getAddressRoad());
		trainer.setCity(dto.getCity());
		trainer.setInternal(dto.getInternal());
		trainer.setZipCode(dto.getZipCode());
		trainer.setTelephone(dto.getTelephone());
		trainer.setActive(dto.isActive());
		return trainer;
	}
	
	public static TrainerDto model2Dto(Trainer model) {		
		TrainerDto dto = new TrainerDto();
		dto.setId(model.getId());
		dto.setFirstName(model.getFirstName());
		dto.setLastName(model.getLastName());
		dto.setIdCode(model.getIdCode());
		dto.setEmail(model.getEmail());
		dto.setAddressRoad(model.getAddressRoad());
		dto.setCity(model.getCity());
		dto.setInternal(model.getInternal());
		dto.setZipCode(model.getZipCode());
		dto.setTelephone(model.getTelephone());
		dto.setActive(model.isActive());
		return dto;
	}

	public static Module dto2Model(ModuleDto dto) throws IOException{
		Module module = new Module();
		module.setTitle(dto.getTitle());
		if(dto.getProgramPdf() != null) {
		module.setProgramPdf(dto.getProgramPdf().getBytes());
		}
		return module;
	}
	
	public static ModuleDto model2Dto(Module model) {		
		ModuleDto dto = new ModuleDto();
		dto.setTitle(model.getTitle());
		return dto;
	}
	
	public static Course dto2Model(CourseDto dto) {
		Course course = new Course();
		if (dto.getId() != null) {
			course.setId(dto.getId());
		}
		course.setTitle(dto.getTitle());
		course.setActive(dto.getActive());
		course.setPublished(dto.getPublished());

		String commaRegex = "\\s*,[,\\s]*";


		/*if (!StringUtils.isEmpty(dto.getTopic())) {
			for (String topic: dto.getTopic().split(commaRegex)) {
				course.addTopic(new Topic(topic));
			}
		}

			if (!dto.getTopic().isEmpty()){
			for (TopicDto topic : dto.getTopic()) {
				if

			}
		}

		if (!dto.getTags().isEmpty()) dto.getTags().forEach(tagDto -> course.addTag(dto2Model(tagDto)));

		if (!dto.getTopic().isEmpty()) dto.getTopic().forEach(topicDto -> course.addTopic(dto2Model(topicDto)));
		*/





		/*if (!StringUtils.isEmpty(dto.getTags())){
			String[] tags = dto.getTags().split(commaRegex);
			for (String tag: tags) {
				course.addTag(new Tag(tag));
			}
		}*/



		/*return course;
	}
	
	public static CourseDto model2Dto(Course model) {		
		CourseDto dto = new CourseDto();
		dto.setId(model.getId());
		dto.setTitle(model.getTitle());
		dto.setActive(model.getActive());
		dto.setPublished(model.getPublished());

		for (Module i : model.getModules()) {
			dto.getModules().add(model2Dto(i));
		}

		List<String> tagNames = model.getTags()
				.stream()
				.map(Tag::getName)
				.collect(Collectors.toList());
		dto.setTags(String.join(",", tagNames));

		List<String> topicNames = model.getTopics()
				.stream()
				.map(Topic::getName)
				.collect(Collectors.toList());
		dto.setTopic(String.join(",", topicNames));

		if (!model.getTopics().isEmpty()) model.getTopics().forEach(topic -> dto.getTopic().add(model2Dto(topic)));
		if (!model.getTags().isEmpty()) model.getTags().forEach(tag -> dto.getTags().add(model2Dto(tag)));

		return dto;
	}

	public static Edition dto2Model(EditionDto dto) throws ParseException {		
		Edition edition = new Edition();
		edition.setStartDate(TmsUtils.string2Date(dto.getStartDate()));
		edition.setEndDate(TmsUtils.string2Date(dto.getEndDate()));
		edition.setDeadline(TmsUtils.string2Date(dto.getDeadline()));
		edition.setOpen(dto.getOpen());
		return edition;
	}
	
	public static EditionDto model2Dto(Edition model) {
		EditionDto dto = new EditionDto();
		dto.setStartDate(TmsUtils.date2String(model.getStartDate()));
		dto.setEndDate(TmsUtils.date2String(model.getEndDate()));
		dto.setDeadline(TmsUtils.date2String(model.getDeadline()));
		dto.setOpen(model.getOpen());
		return dto;
	}
	
	public static Tag dto2Model(TagDto dto) {		
		Tag tag = new Tag();
		if (dto.getId() != null) {
			tag.setId(dto.getId());
		}
		tag.setName(dto.getName());
		return tag;
	}
	
	public static TagDto model2Dto(Tag model) {		
		TagDto dto = new TagDto();
		dto.setId(model.getId());
		dto.setName(model.getName());
		return dto;
	}


	public static void mergeDto2Model(CourseDto newCourseDto, Course model2Update) {
		if(!StringUtils.isEmpty(newCourseDto.getTitle())){
			model2Update.setTitle(newCourseDto.getTitle());
		}
		if(!(newCourseDto.getActive() == null)){
			model2Update.setActive(newCourseDto.getActive());
		}
		if(!(newCourseDto.getPublished() == null)){
			model2Update.setPublished(newCourseDto.getPublished());
		}
		if (!newCourseDto.getTopic().isEmpty())
			newCourseDto.getTopic().forEach(topicDto -> model2Update.addTopic(dto2Model(topicDto)));

		if (!newCourseDto.getTags().isEmpty())
			newCourseDto.getTags().forEach(tagDto -> model2Update.addTag(dto2Model(tagDto)));
	}*/

}
