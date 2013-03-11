import java.util.LinkedList;
import java.lang.Math;

public class regionCombine {
	public static void main(String args[]) {
		RegionCombine1 regcomb = new RegionCombine1();
		Region reg = new Region(1, 5);
		regcomb.insert(reg);

		reg = new Region(6, 10);
		regcomb.insert(reg);

		reg = new Region(12, 17);
        regcomb.insert(reg);

		//reg = new Region(2, 4);
        //regcomb.insert(reg);

		regcomb.PrintList();
		return;
	}


}

class Region {
    public int left;
    public int right;

    public Region(int l, int r) {
        this.left = l;
        this.right = r;
    }
}

class RegionCombine1 {
	private LinkedList<Region> regionList;

	public RegionCombine1() {
		this.regionList = new LinkedList<>();
	}

	public void insert(Region newRegion) {
		if (0 >= regionList.size()) {
			regionList.add(newRegion);
			return;
		}

		int i = 0;
		Region r;
		Region combination;
		// first find the position for left, and trigger conbination
		for (i = 0; i < regionList.size(); i++) {
			r = regionList.get(i);
			if (newRegion.left > regionList.get(i).right)
				continue;

			if (newRegion.right < regionList.get(i).left) { // insert in this empty
				regionList.add(i, newRegion);
				return;
			}

			// combine and trigger combination
			combination = Combination(newRegion, regionList.get(i));
			regionList.set(i, combination);
			break;
		}

		if (i == regionList.size()) {
			regionList.add(i, newRegion);
			return;
		} else if (i == regionList.size() - 1) {
			return;
		}

		while (true) {
			if (regionList.size() <= i + 1)
				return;

			if (regionList.get(i).right < regionList.get(i + 1).left)
				return;

			combination = Combination(regionList.get(i), regionList.get(i + 1));
            regionList.set(i, combination);
			regionList.remove(i + 1);
		}
	}

	private Region Combination(Region region1, Region region2) {
		Region comb = new Region(Math.min(region1.left, region2.left), Math.max(region1.right, region2.right));
		//System.out.println("combine: " + comb.left + ", " + comb.right);
		return comb;
	}

	public void PrintList() {
		for (Region region : this.regionList) {
			System.out.print("[" + region.left + ", " + region.right + "]" + ", ");
		}
		
		System.out.print("\n");
		return;
	}
}
