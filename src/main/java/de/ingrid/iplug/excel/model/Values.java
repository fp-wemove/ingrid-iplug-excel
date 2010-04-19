package de.ingrid.iplug.excel.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class to get and set values.
 *
 */
public class Values implements Externalizable, Iterable<Point> {

    private final SortedMap<Point, Comparable<? extends Object>> _values = new TreeMap<Point, Comparable<? extends Object>>();

	/**
	 * Add value.
	 * 
	 * @param point
	 * @param value
	 */
	public void addValue(final Point point, final Comparable<? extends Object> value) {
		_values.put(point, value);
	}

	/** 
	 * Get value.
	 * 
	 * @param point
	 * @return
	 * 		Value.
	 */
	public Comparable<? extends Object> getValue(final Point point) {
		return _values.get(point);
	}

	/**
	 * Get value.
	 * 
	 * @param x
	 * @param y
	 * @return
	 * 		Value.
	 */
	public Comparable<? extends Object> getValue(final int x, final int y) {
		return _values.get(new Point(x, y));
	}

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Point> iterator() {
        return _values.keySet().iterator();
    }

    /**
     * Get size
     * 
     * @return Values size.
     */
    public int getSize() {
        return _values.size();
    }

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@SuppressWarnings("unchecked")
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
		_values.clear();
		final int size = in.readInt();
		for (int i = 0; i < size; i++) {
            final Point point = (Point) in.readObject();
            final Comparable<? extends Object> serializable = (Comparable<Object>) in.readObject();
			_values.put(point, serializable);
		}
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(final ObjectOutput out) throws IOException {
		out.writeInt(_values.size());
        final Set<Point> set = _values.keySet();
        for (final Point point : set) {
            out.writeObject(point);
            out.writeObject(_values.get(point));
		}
	}
}
