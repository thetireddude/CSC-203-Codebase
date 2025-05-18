package equality;
import java.time.LocalTime;

public class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   // TODO: equals and hashCode methods for CourseSection
   public boolean equals(CourseSection section){
      if(section == null){
         return false;
      }
      if(!(this.getClass() == section.getClass())){
         return false;
      }
      return this.prefix == section.prefix && this.number == section.number && this.enrollment == section.enrollment && (startTime.getHour() == section.startTime.getHour() && startTime.getMinute() == section.startTime.getMinute()) && (endTime.getHour() == section.endTime.getHour() && endTime.getMinute() == section.endTime.getMinute());
   }

   public int hashCode(){

      return (this.prefix.hashCode() + Integer.parseInt(this.number) + enrollment) * 17;
   }

}
