import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackForm extends JFrame {
    JTextField nameField;
    JRadioButton maleButton, femaleButton;
    JCheckBox javaCheckBox, pythonCheckBox, aiCheckBox;
    JTextArea feedbackArea;
    JButton submitButton;

    public FeedbackForm() {
        setTitle("Feedback Form");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        namePanel.add(nameField);
        panel.add(namePanel);

        // Gender
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(new JLabel("Gender:"));
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        panel.add(genderPanel);

        // Courses
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        coursePanel.add(new JLabel("Courses Interested:"));
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        aiCheckBox = new JCheckBox("AI/ML");
        coursePanel.add(javaCheckBox);
        coursePanel.add(pythonCheckBox);
        coursePanel.add(aiCheckBox);
        panel.add(coursePanel);

        // Feedback
        JPanel feedbackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        feedbackPanel.add(new JLabel("Feedback:"));
        feedbackArea = new JTextArea(5, 25);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        feedbackPanel.add(scrollPane);
        panel.add(feedbackPanel);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    private void submitForm() {
        String name = nameField.getText();
        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not selected");  
        String courses = "";
        if (javaCheckBox.isSelected()) courses += "Java ";
        if (pythonCheckBox.isSelected()) courses += "Python ";
        if (aiCheckBox.isSelected()) courses += "AI/ML ";
        String feedback = feedbackArea.getText();

        JOptionPane.showMessageDialog(this,
            "Name: " + name +
            "\nGender: " + gender +
            "\nCourses: " + courses +
            "\nFeedback: " + feedback
        );
    }

    public static void main(String[] args) {
        new FeedbackForm();
    }
}