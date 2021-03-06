package easyflow.custom.jgraphx.editor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JWindow;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;

import easyflow.custom.util.URIUtil;
import easyflow.example.Examples;
import easyflow.ui.DefaultProject;
import easyflow.ui.UiFactory;

public class ConfigureProjectDialog extends JWindow implements ActionListener {
	
	EMap<String,DefaultProject>     examples;
	private static final Logger     logger = Logger.getLogger(EasyFlowToolBar.class);
	JFileChooser fc;
	JButton      selectFileButton = new JButton("Select Path");
	JButton      validateButton   = new JButton("Validate");
	JButton      closeButton      = new JButton("Close");
	//JTextField   uriTextField     = new JTextField("https://bitbucket.org/thiema/easyflow/downloads/main.json");
	JTextField   selectedFileText = new JTextField("src/easyflow/custom/examples/sequencing");
	String       defaultFilePath;
	JPanel       panel            = new JPanel(new GridLayout(0, 1));
	JPanel       sfPanel          = new JPanel(new GridLayout(0, 3));
	JDialog      dialog           = new JDialog();// nicht modal

	boolean      isFromJar        = false;	
	final ButtonGroup group       = new ButtonGroup();
	/**/
	private DefaultProject selectedProject;
	
	public ConfigureProjectDialog(final EMap<String, DefaultProject> examples, int xpos, int ypos, String defaultRepos)
	{
		super();
		this.examples = examples;
		this.defaultFilePath = defaultRepos;
		selectedFileText.setText(this.defaultFilePath);
		fc = new JFileChooser(this.defaultFilePath);
		//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setToolTipText("Either select the main configuration file in the json format or the directory where the file main.json is located.");
        selectFileButton.addActionListener(this);
        validateButton.addActionListener(this);
        closeButton.addActionListener(this);
        sfPanel.add(selectFileButton);
        sfPanel.add(validateButton);
        sfPanel.add(closeButton);
        panel.add(sfPanel);
        //uriTextField.setEnabled(false);
        //userProject.setFromJar(false);    
        
		// add the radio buttons to select predefined configs
        Iterator<Entry<String, DefaultProject>> itEx = examples.iterator();
        while (itEx.hasNext())
		//for (final String exampleName : examples.keySet())
		{
        	final String exampleName = itEx.next().getKey();
			//popup.add(newContentPane);
			JRadioButton radioButton = new JRadioButton(exampleName);
			radioButton.setActionCommand(exampleName);
			radioButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					selectFileButton.setEnabled(false);
					selectedFileText.setEnabled(false);
					selectedFileText.setText(examples.get(exampleName).getConfigSource().getPath());
					//uriTextField.setEnabled(false);
					//selectedFileText.setText(getExamples().getExamples().get(exampleName).getConfigSource().toString());
				}
			});
			//radioButton.setSelected(true);
			//Group the radio buttons.
			group.add(radioButton);
			panel.add(radioButton);
		}
		JRadioButton radioButton = new JRadioButton("user input");
		radioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectFileButton.setEnabled(true);
				selectedFileText.setEnabled(true);
				//uriTextField.setEnabled(false);
			}
		});

		radioButton.setActionCommand("userInputFile");
		radioButton.setSelected(true);
		radioButton.addActionListener(this);
//disable uri source, no implemented anyway 
/*		
		JRadioButton uriRadioButton = new JRadioButton("uri");
		uriRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uriTextField.setEnabled(true);
			}
		});
		uriRadioButton.setActionCommand("userInputURI");
		uriRadioButton.setSelected(true);
		uriRadioButton.addActionListener(this);
				group.add(uriRadioButton);
				panel.add(uriRadioButton);
				panel.add(uriTextField);
*/
		//Group the radio buttons.
		group.add(radioButton);
		panel.add(radioButton);	
		panel.add(selectedFileText);
		//dialog.setBounds(editor.getGraphComponent().getX(), 
        	//	editor.getGraphComponent().getY(), 300, 150);
		dialog.setBounds(xpos, ypos, 300, 150);
		dialog.add(panel);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultProject defaultProject    = UiFactory.eINSTANCE.createDefaultProject();
		defaultProject.setFromJar(isFromJar);
		logger.debug("action performed");
        if (e.getSource() == selectFileButton) {
        	
            int returnVal = fc.showOpenDialog(panel);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
            	// select the file and set project path
                //File file = fc.getSelectedFile();
                
                //logger.debug("Opening: " + file.getName() + "."+" "+fc.getSelectedFile().getAbsolutePath().toString());
                //selectedFileText.setText(file.getName());
            	String path = fc.getSelectedFile().getAbsolutePath();
                logger.debug("Opening: "+path);
                selectedFileText.setText(path);

               	defaultProject.setConfigAndBasePath(path);
            } else {
            	logger.debug("Open command cancelled by user.");
            }
        }
        else if (e.getSource() == "deserializeProject")
        {
        	
        }
        else if (e.getSource() == closeButton)
        {
        	logger.debug("close action");
        	if (selectProject(defaultProject) && getSelectedProject().validate())
        	{
        		logger.debug("valid project found, set default. ");
        	}
        	
        	//dialog.dispose();
        	dialog.setVisible(false);
        }
        else if (e.getSource() == validateButton)
        {
        	selectProject(defaultProject);
        	logger.debug(getSelectedProject().getBaseURI()+" "+getSelectedProject().getConfigSource());
        	if (getSelectedProject() != null && getSelectedProject().validate())
        		//JOptionPane.showMessageDialog(this, "Project settings are valid !");
        		;
        	else
        		JOptionPane.showMessageDialog(this, "Invalid project settings found !",
        				"Inane error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        	selectedFileText.setText(this.defaultFilePath);
        	//logger.debug("no action defined.");
        }
        
        
	}
	
	private boolean selectProject(DefaultProject defaultProject) {
		
		boolean rc = true;
		DefaultProject curProject = null;
		if (group.getSelection().getActionCommand().equals("userInputFile"))
    	{
    		curProject = defaultProject;
    		curProject.setConfigAndBasePath(selectedFileText.getText());
    	}
    	else if (group.getSelection().getActionCommand().equals("userInputURI"))
    	{
    		throw new UnsupportedOperationException();
    	//}
    		//curProject = defaultProject;
    		//try {
				//curProject.setConfigSource(
					//	URIUtil.createURI(uriTextField.getText(), null));
    			
			//} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			//}
    	}
    	else if (examples.containsKey(group.getSelection().getActionCommand()))
    		curProject = examples.get(group.getSelection().getActionCommand());
    	else
    		rc = false;
		if (rc)
			selectedProject=curProject;
		return rc;
	}
	
	public boolean isFromJar() {
		return isFromJar;
	}
	
	public void setFromJar(boolean isFromJar) {
		this.isFromJar = isFromJar;
	}
	
	public DefaultProject getSelectedProject()
	{
		return selectedProject;
	}

}
