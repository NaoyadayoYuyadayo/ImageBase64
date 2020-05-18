import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Sample1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String image = "C:\\Users\\ctc2019\\Documents\\pleiades-2020-03-java-win-64bit-jre_20200322\\pleiades\\workspace\\Picture_test\\src\\Arduino1.png";

		JButton encode = new JButton("encode");
		encode.addActionListener(e -> {
		  JFileChooser chooser = new JFileChooser();
		  chooser.addChoosableFileFilter(
		      new FileNameExtensionFilter(image, "png"));
		  int retvalue = chooser.showOpenDialog(encode);
		  if (retvalue == JFileChooser.APPROVE_OPTION) {
		    Path path = chooser.getSelectedFile().toPath();
		    try {
		      textArea.setText(
		          Base64.getEncoder().encodeToString(Files.readAllBytes(path)));
		    } catch (IOException ex) {
		      ex.printStackTrace();
		    }
		  }
		});

		JButton decode = new JButton("decode");
		decode.addActionListener(e -> {
		  String b64 = textArea.getText();
		  if (b64.isEmpty()) {
		    return;
		  }
		  try (InputStream is = new ByteArrayInputStream(
		          Base64.getDecoder().decode(b64.getBytes(StandardCharsets.ISO_8859_1)))) {
		    label.setIcon(new ImageIcon(ImageIO.read(is)));
		  } catch (IOException ex) {
		    ex.printStackTrace();
		  }
		});
	}

}
