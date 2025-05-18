package comparator;

import java.util.Comparator;

public class ComposedComparator implements Comparator<Applicant> {
    Comparator<Applicant> c1;
    Comparator<Applicant> c2;

    public ComposedComparator(Comparator<Applicant> c1, Comparator<Applicant> c2){
        this.c1 = c1;
        this.c2 = c2;
    }
    public int compare(Applicant app1, Applicant app2){
        int result = c1.compare(app1, app2);
        if(result == 0){
            result = c2.compare(app1, app2);
        }
        return result;
    }
}
