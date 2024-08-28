package app;

public class CourseDAO implements GenericDAO<Course, Integer> {
    @Override
    public void saveEntity(Course entity) {

    }

    @Override
    public int deleteEntity(Integer id) {
        return 0;
    }

    @Override
    public Course findEntity(Integer id) {
        return null;
    }

    @Override
    public Course updateEntity(Course entity, Integer id) {
        return null;
    }
}
