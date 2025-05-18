package comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Applicant> {
    public int compare(Applicant app1, Applicant app2){
        return app1.getName().compareTo(app2.getName());
    }
}
