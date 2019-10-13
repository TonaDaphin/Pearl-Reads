import android.content.Context;
import android.widget.ArrayAdapter;

public class FictionArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] fictionals;
    private String[] fictionauthors;

    public FictionArrayAdapter (Context mContext, int resource, String[] fictionals, String[] fictionauthors) {
        super(mContext, resource);
        this.mContext = mContext;
        this.fictionals = fictionals;
        this.fictionauthors = fictionauthors;
    }
    @Override
    public Object getItem(int position) {
        String fiction = fictionals[position];
        String authors = fictionauthors[position];
        return String.format("%s \nAuthor: %s", fiction, authors);
    }

    @Override
    public int getCount() {
        return fictionals.length;
    }
}
