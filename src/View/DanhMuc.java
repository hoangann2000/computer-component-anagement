package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMuc {

	private String chon;
	private JPanel pnl;
	private JLabel lbl;

	public DanhMuc() {
	}

	public DanhMuc(String chon, JPanel pnl, JLabel lbl) {
		this.chon = chon;
		this.pnl = pnl;
		this.lbl = lbl;
	}

	public String getChon() {
		return chon;
	}

	public void setChon(String chon) {
		this.chon = chon;
	}

	public JPanel getPnl() {
		return pnl;
	}

	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

}
