import styled from '@emotion/styled';

function IconButton({ ftcolor, bgcolor, text }) {
  return (
    <Container ftcolor={ftcolor} bgcolor={bgcolor}>
      {text}
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  align-items: center;
  background-color: ${props => props.bgcolor};
  color: ${props => props.ftcolor};
  padding: 4px;
  border-radius: 30px;
  border: none;
  cursor: pointer;
`;

export default IconButton;
