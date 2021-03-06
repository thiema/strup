package easyflow.custom.jgraphx.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.mxgraph.examples.swing.GraphEditor;
import com.mxgraph.examples.swing.editor.EditorPalette;
import com.mxgraph.examples.swing.editor.EditorToolBar;
import com.mxgraph.examples.swing.editor.SchemaEditorMenuBar;
import com.mxgraph.examples.swing.editor.SchemaEditorToolBar;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.util.mxGraphTransferable;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxStylesheet;

import easyflow.core.CoreFactory;
import easyflow.data.DataFactory;
import easyflow.data.DataLink;
import easyflow.data.DataPort;
import easyflow.core.Task;
import easyflow.custom.jgraphx.ComposeWorkflowPanel;
import easyflow.custom.ui.CmdLineParser;
import easyflow.custom.ui.Easyflow;
import easyflow.custom.util.GlobalConstants;
import easyflow.custom.util.GlobalVar;


// the menu- and tool-bars and the compose workflow panel are currently deactivated:
// find the comments: (in class constructor)
//setComposeWorkflowPanel(insertComposeWorkflowPanel("Compostion"));
//upperPanel.add(new EditorToolBar(this, JToolBar.HORIZONTAL), BorderLayout.NORTH);
//
// see: EasyFlowBasicGraphEditor, createFrame() for jmenubar 
public class EasyFlowGraphEditor extends EasyFlowBasicGraphEditor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7007225006753337933L;
	private static final Logger logger = Logger.getLogger(EasyFlowBasicGraphEditor.class);

	/**
	 * 
	 */
	private JPanel upperPanel;
	private ComposeWorkflowPanel composeWorkflowPanel;
	private JTextPane logMsgTextArea;
	
	
	public EasyFlowGraphEditor()
	{
		// super("mxGraph for JFC/Swing", new SchemaGraphComponent(new mxGraph()
		super("StruP", new EasyFlowGraphComponent(new EasyFlowGraph()));

		final EasyFlowGraph graph = (EasyFlowGraph) graphComponent.getGraph();
		// logger.debug(((EasyFlowGraph)getGraphComponent().getGraph()).hashCode());
		
		//setStyleSheet(graph.getStylesheet(), getGraphComponent().getViewport().getBackground());
		setStyleSheet(graph.getStylesheet(), null);
		
setComposeWorkflowPanel(insertComposeWorkflowPanel("Compostion"));
		// Creates a single shapes palette
		EditorPalette shapesPalette = insertPalette("Editor");

		// Sets the edge template to be used for creating new edges if an edge
		// is clicked in the shape palette
		shapesPalette.addListener(mxEvent.SELECT, new mxIEventListener() {
			public void invoke(Object sender, mxEventObject evt) {
				Object tmp = evt.getProperty("transferable");

				if (tmp instanceof mxGraphTransferable) {
					mxGraphTransferable t = (mxGraphTransferable) tmp;
					Object cell = t.getCells()[0];

					if (graph.getModel().isEdge(cell)) {
						((EasyFlowCustomGraph) graph).setEdgeTemplate(cell);
					}
				}
			}
		});
		graphOutline.setVisible(true);

		Task templateTask=CoreFactory.eINSTANCE.createTask();
		templateTask.setName(GlobalConstants.TEMPLATE_TASK_NAME);
		GlobalVar.setTemplateTask(templateTask);
		mxCell templateCell = (mxCell) graph.createNewCell(templateTask, null);
		templateCell.getGeometry().setAlternateBounds(
				new mxRectangle(0, 0, 140, 25));
		templateCell.setVertex(true);
		shapesPalette
			.addTemplate("Task", new ImageIcon(GraphEditor.class
										.getResource("/com/mxgraph/examples/swing/images/rectangle.png")),
										templateCell);
		
		DataLink templateDataLink=DataFactory.eINSTANCE.createDataLink();
		DataPort templateDataPort=DataFactory.eINSTANCE.createDataPort();
		templateDataPort.setName(GlobalConstants.TEMPLATE_DATA_PORT_NAME);
		templateDataLink.setDataPort(templateDataPort);
		GlobalVar.setTemplateLink(templateDataLink);
		mxGeometry geometry = new mxGeometry(0, 0, 120, 120);
		geometry.setTerminalPoint(new mxPoint(0, 120), true);
		geometry.setTerminalPoint(new mxPoint(120, 0), false);
		geometry.setRelative(true);
		mxCell templateEdge = (mxCell) graph.createNewCell(templateDataLink, geometry);
		templateEdge.setEdge(true);
		
		shapesPalette
			.addTemplate("Link", new ImageIcon(GraphEditor.class
										.getResource("/com/mxgraph/examples/swing/images/arrow.png")),
										templateEdge);
		
		getGraphComponent().getGraph().setCellsResizable(false);
		getGraphComponent().setConnectable(false);
		getGraphComponent().getGraphHandler().setCloneEnabled(false);
		getGraphComponent().getGraphHandler().setImagePreview(false);
		// Prefers default JComponent event-handling before mxCellHandler handling
		//getGraphComponent().getGraphHandler().setKeepOnTop(false);
		upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());
		EasyFlowToolBar easyFlowToolBar = new EasyFlowToolBar(this, JToolBar.HORIZONTAL);
		// add the tool bar (only in developer mode, which was determined in EasyFlowToolBar Constructor)
		if (GlobalVar.isDevloperMode())
			upperPanel.add(new EditorToolBar(this, JToolBar.HORIZONTAL), BorderLayout.NORTH);
		upperPanel.add(easyFlowToolBar, BorderLayout.SOUTH);
		add(upperPanel, BorderLayout.NORTH);
		
	}

	
	private static Map<String, Object> getBaseStyle()
	{
		Map<String, Object> baseStyle = new Hashtable<String, Object>();
		return baseStyle;
	}
	
	private static String getRGB(Color color)
	{
		String vertexFillColor="";
		vertexFillColor+=Integer.toHexString(color.getRed()).toUpperCase();
		vertexFillColor+=Integer.toHexString(color.getGreen()).toUpperCase();
		vertexFillColor+=Integer.toHexString(color.getBlue()).toUpperCase();
		//logger.debug(vertexFillColor);
		return vertexFillColor;
	}
	
	private static Map<String, Object> getVertexStyle(Color color)
	{
		Map<String, Object> vertexStyle = new Hashtable<String, Object>();
		//vertexStyle.put(mxConstants.STYLE_AUTOSIZE, "1");
        //vertexStyle.put(mxConstants.STYLE_RESIZABLE, "1");
        //vertexStyle.put(mxConstants., "5");
        //vertexStyle.put(mxConstants.STYLE_NOLABEL, 1);
        //vertexStyle.put(mxConstants.STYLE_TEXT_OPACITY, 0);
		
		if (color != null)
		{    
	        //baseStyle.put(mxConstants.STYLE_STROKECOLOR, vertexFillColor);
	        //vertexStyle.put(mxConstants.STYLE_STROKECOLOR, vertexFillColor);
	        vertexStyle.put(mxConstants.STYLE_FILLCOLOR, getRGB(color));
		}
		
		return vertexStyle;
	}
	
	private static Map<String, Object> getDefaultEdgeStyle(Color color)
	{
		Map<String, Object> edgeStyle = new Hashtable<String, Object>();
		edgeStyle.put(mxConstants.STYLE_STROKEWIDTH, 3);
        edgeStyle.put(mxConstants.STYLE_FILLCOLOR, "#000000");
        edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
        
        //edgeStyle.put(mxConstants.STYLE_FILLCOLOR, vertexFillColor);
        //edgeStyle.put(mxConstants.STYLE_NOLABEL, 1);
        //edgeStyle.put(mxConstants.STYLE_TEXT_OPACITY, 0);
        if (color != null)
        	edgeStyle.put(mxConstants.STYLE_FILLCOLOR, getRGB(color));
        else
        	edgeStyle.put(mxConstants.STYLE_FILLCOLOR, mxUtils.getHexColorString(Color.BLACK));
        
        return edgeStyle;
	}
	
	private static Map<String, Object> getCircumventingTaskEdgeStyle(Color color) {
		Map<String, Object> edgeStyle = new Hashtable<String, Object>();
		edgeStyle.put(mxConstants.STYLE_STROKEWIDTH, 3);
		edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(Color.CYAN));		
        //edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OVAL);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
        //if (color != null)
        	//edgeStyle.put(mxConstants.STYLE_TEXT_OPACITY, 0);

        return edgeStyle;
	}
	
	private static Map<String, Object> getMissingInOutDataPortEdgeStyle(Color color) {
		Map<String, Object> edgeStyle = new Hashtable<String, Object>();
		edgeStyle.put(mxConstants.STYLE_STROKEWIDTH, 3);
		edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(Color.RED));		
        //edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OVAL);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
        //if (color != null)
        	edgeStyle.put(mxConstants.STYLE_TEXT_OPACITY, 0);

        return edgeStyle;
	}
	
	private static void setStyleSheet(mxStylesheet stylesheet, Color color) {
		
		// base style
        //Map<String, Object> baseStyle   = getBaseStyle();

        // custom vertex style
        stylesheet.putCellStyle(GlobalConstants.VERTEX_STYLE, getVertexStyle(null));
        stylesheet.putCellStyle(GlobalConstants.TOOL_VERTEX_STYLE, getVertexStyle(Color.LIGHT_GRAY));
        // custom edge style
        Map<String, Object> edgeStyle = getDefaultEdgeStyle(color);        
        stylesheet.putCellStyle(GlobalConstants.EDGE_STYLE, edgeStyle);
        
        // task circumventing edges
        stylesheet.putCellStyle(GlobalConstants.CIRCUMVENTING_TASK_EDGE_STYLE, getCircumventingTaskEdgeStyle(color));
        
        stylesheet.putCellStyle(GlobalConstants.MISSING_IN_OUT_DATAPORT_EDGE_STYLE, getMissingInOutDataPortEdgeStyle(color));
        
        //GlobalVar.setDefaultVertexStyle(vertexStyle);
        //GlobalVar.setDefaultEdgeStyle(edgeStyle);
        
        /*
        mxDefaultTextShape textShape=new mxDefaultTextShape(){
        	public void paintShape(mxGraphics2DCanvas canvas, String text,
                    mxCellState state, Map<String, Object> style)
        	{
        		Rectangle rect = state.getLabelBounds().getRectangle();
        		Graphics2D g = canvas.getGraphics();
        	}

        };
        mxGraphics2DCanvas.putTextShape("default", textShape);
        mxIShape shape=new mxBasicShape() {
        	
        };
        
        mxGraphics2DCanvas.putShape("default", shape);
        */
    }


	/**
	 * 
	 */
	protected void installToolBar()
	{
		add(new SchemaEditorToolBar(this, JToolBar.HORIZONTAL),
				BorderLayout.NORTH);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{	
		
		try
		{
			/*
			CmdLineParser cmdLineParser = new CmdLineParser();
			cmdLineParser.initOptions();
			cmdLineParser.parseOptions(args);
					
			Level level = Level.ERROR;
			if (cmdLineParser.getLogLevel() != null)
			{
				String loglevel = cmdLineParser.getLogLevel();
				
				if (loglevel.equalsIgnoreCase("FATAL"))
					level = Level.FATAL;
				else if (loglevel.equalsIgnoreCase("ERROR"))
					level = Level.ERROR;
				else if (loglevel.equalsIgnoreCase("WARN"))
					level = Level.WARN;
				else if (loglevel.equalsIgnoreCase("INFO"))
					level = Level.INFO;
				else if (loglevel.equalsIgnoreCase("DEBUG"))
					level = Level.DEBUG;
				else if (loglevel.equalsIgnoreCase("TRACE"))
					level = Level.TRACE;
			}
			
			Properties props = new Properties();
			try {
				InputStream configStream = Easyflow.class
						.getResourceAsStream("/log4j.properties");
				props.load(configStream);
				configStream.close();
				//System.out.println("INFO: logger configuration file loaded.");
			} catch (IOException e) {
				System.out
						.println("INFO: Cannot laod configuration file ");
			}
			// props.setProperty("log4j.rootLogger","DEBUG, file");
			// props.setProperty("log4j.appender.file.File","out.log");
			props.setProperty("log4j.rootLogger", level.toString()+ ", stdout");
			props.setProperty("log4j.logger.easyflow", level.toString());
			LogManager.resetConfiguration();
			PropertyConfigurator.configure(props);
			logger.debug("loglevel="+logger.getLevel()+" "+Logger.getRootLogger().getLevel()
					+" logger="+logger.hashCode()+" rootLogger="+Logger.getRootLogger().hashCode());
			
			*/
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		EasyFlowGraphEditor editor = new EasyFlowGraphEditor();
		editor.createFrame().setVisible(true);
	}

	public ComposeWorkflowPanel getComposeWorkflowPanel() {
		return composeWorkflowPanel;
	}

	public void setComposeWorkflowPanel(ComposeWorkflowPanel composeWorkflowPanel) {
		this.composeWorkflowPanel = composeWorkflowPanel;
	}

	public JTextPane getTextAreaForLogMsg()
	{
		return logMsgTextArea;
	}

}
